package mediabrowser.apiinteraction.android.sync.server.mediasync;

import mediabrowser.apiinteraction.EmptyResponse;
import mediabrowser.apiinteraction.Response;
import mediabrowser.apiinteraction.sync.data.ILocalAssetManager;
import mediabrowser.model.apiclient.ServerInfo;
import mediabrowser.model.logging.ILogger;
import mediabrowser.model.sync.LocalItem;
import mediabrowser.model.sync.SyncDataResponse;

import java.util.ArrayList;

/**
 * Created by Luke on 3/17/2015.
 */
public class SyncDataInnerResponse extends Response<SyncDataResponse>
{
    private ILocalAssetManager localAssetManager;
    private ServerInfo serverInfo;
    private boolean syncUserItemAccess;
    private ILogger logger;

    public SyncDataInnerResponse(EmptyResponse innerResponse, ILocalAssetManager localAssetManager, ServerInfo serverInfo, boolean syncUserItemAccess, ILogger logger){

        super(innerResponse);
        this.localAssetManager = localAssetManager;
        this.serverInfo = serverInfo;
        this.syncUserItemAccess = syncUserItemAccess;
        this.logger = logger;
    }

    @Override
    public void onResponse(SyncDataResponse result) {

        for(String itemIdToRemove : result.getItemIdsToRemove())
        {
            removeItem(serverInfo.getId(), itemIdToRemove);
        }

        if (syncUserItemAccess)
        {
            logger.Debug("Syncing users with access");

            for (String itemId : result.getItemUserAccess().keySet())
            {
                LocalItem localItem = localAssetManager.getLocalItem(serverInfo.getId(), itemId);

                ArrayList<String> userIdsWithAccess = result.getItemUserAccess().get(itemId);

                if (!userIdsWithAccess.equals(localItem.getUserIdsWithAccess()))
                {
                    localItem.setUserIdsWithAccess(userIdsWithAccess);
                    localAssetManager.addOrUpdate(localItem);
                }
            }
        }

        logger.Debug("Calling SyncDataInnerResponse.triggerInnerResponse");
        triggerInnerResponse();
    }

    private void removeItem(String serverId, String itemId)
    {
        logger.Debug("Removing item. ServerId: %s, ItemId: %s", serverId, itemId);
        LocalItem localItem = localAssetManager.getLocalItem(serverId, itemId);

        if (localItem == null)
        {
            return;
        }

        ArrayList<String> additionalFiles = localItem.getAdditionalFiles();
        String localPath = localItem.getLocalPath();

        localAssetManager.delete(localItem);

        for (String file : additionalFiles)
        {
            localAssetManager.deleteFile(file);
        }

        localAssetManager.deleteFile(localPath);
    }
}
