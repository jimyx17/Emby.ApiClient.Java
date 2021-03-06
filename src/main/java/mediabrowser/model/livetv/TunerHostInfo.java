package mediabrowser.model.livetv;

public class TunerHostInfo
{
	private String Id;
	public final String getId()
	{
		return Id;
	}
	public final void setId(String value)
	{
		Id = value;
	}
	private String Url;
	public final String getUrl()
	{
		return Url;
	}
	public final void setUrl(String value)
	{
		Url = value;
	}
	private String Type;
	public final String getType()
	{
		return Type;
	}
	public final void setType(String value)
	{
		Type = value;
	}
	private String DeviceId;
	public final String getDeviceId()
	{
		return DeviceId;
	}
	public final void setDeviceId(String value)
	{
		DeviceId = value;
	}
	private boolean ImportFavoritesOnly;
	public final boolean getImportFavoritesOnly()
	{
		return ImportFavoritesOnly;
	}
	public final void setImportFavoritesOnly(boolean value)
	{
		ImportFavoritesOnly = value;
	}
	private boolean AllowHWTranscoding;
	public final boolean getAllowHWTranscoding()
	{
		return AllowHWTranscoding;
	}
	public final void setAllowHWTranscoding(boolean value)
	{
		AllowHWTranscoding = value;
	}
	private boolean IsEnabled;
	public final boolean getIsEnabled()
	{
		return IsEnabled;
	}
	public final void setIsEnabled(boolean value)
	{
		IsEnabled = value;
	}
	private String M3UUrl;
	public final String getM3UUrl()
	{
		return M3UUrl;
	}
	public final void setM3UUrl(String value)
	{
		M3UUrl = value;
	}
	private String InfoUrl;
	public final String getInfoUrl()
	{
		return InfoUrl;
	}
	public final void setInfoUrl(String value)
	{
		InfoUrl = value;
	}
	private String FriendlyName;
	public final String getFriendlyName()
	{
		return FriendlyName;
	}
	public final void setFriendlyName(String value)
	{
		FriendlyName = value;
	}
	private int Tuners;
	public final int getTuners()
	{
		return Tuners;
	}
	public final void setTuners(int value)
	{
		Tuners = value;
	}
	private String DiseqC;
	public final String getDiseqC()
	{
		return DiseqC;
	}
	public final void setDiseqC(String value)
	{
		DiseqC = value;
	}
	private String SourceA;
	public final String getSourceA()
	{
		return SourceA;
	}
	public final void setSourceA(String value)
	{
		SourceA = value;
	}
	private String SourceB;
	public final String getSourceB()
	{
		return SourceB;
	}
	public final void setSourceB(String value)
	{
		SourceB = value;
	}
	private String SourceC;
	public final String getSourceC()
	{
		return SourceC;
	}
	public final void setSourceC(String value)
	{
		SourceC = value;
	}
	private String SourceD;
	public final String getSourceD()
	{
		return SourceD;
	}
	public final void setSourceD(String value)
	{
		SourceD = value;
	}

	private int DataVersion;
	public final int getDataVersion()
	{
		return DataVersion;
	}
	public final void setDataVersion(int value)
	{
		DataVersion = value;
	}

	public TunerHostInfo()
	{
		setIsEnabled(true);
		setAllowHWTranscoding(true);
	}
}