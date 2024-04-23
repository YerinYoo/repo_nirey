package com.recorded.common.constants;

public final class Constants {

//	common
	public static final String ABBREVIATION_ADMIN = "Adm"; 
	public static final String ABBREVIATION_USER = "Usr";
	public static final String ABBREVIATION_ADVERTISER = "Adt";
	
//	for paging
	public static final Integer ROW_NUM_TO_SHOW = 20;
	public static final Integer PAGE_NUM_TO_SHOW = 20;

// insert 또는 update 후 페이지 전환 타입: 1:form, 2:list	
	public static final Integer INSERT_AFTER_TYPE = 1;		
	public static final Integer UPDATE_AFTER_TYPE = 1;		
	
	public static final Integer SESSION_MINUTE_XDM = 60;
	
	//유저 로그인 페이지 
	public static final String URL_LOGINUSRFORM = "/recorded/Login";
	
	//어드민 로그인 페이지 
	public static final String URL_LOGINADMFORM = "/loginAdm";
	
	public static final String DATETIME_FORMAT_BASIC = "yyyy-MM-dd HH:mm:ss";

	public static final String DATE_FORMAT_BASIC = "yyyy:MM:dd";
	
	public static final String TIME_FORMAT_BASIC = "HH:mm:ss";
	
	public static final Integer DATE_INTERVAL = -30;
	
	public static final long PASSWOPRD_CHANGE_INTERVAL = 90;
	
	public static final String UPLOADED_PATH_PREFIX_LOCAL = "D:/factory/sts4_4210/repo_nirey_uploaded";
	public static final String UPLOADED_PATH_PREFIX_FOR_VIEW_LOCAL = "/uploaded";
	
	public static final String UPLOADED_RESSOURCE_HANDLER = "/uploaded/**";
	public static final String UPLOADED_RESSOURCE_LOCATIONS = "file:///D:/factory/sts4_4210/repo_nirey_uploaded/";
	
	public static final String UPLOADED_PATH_PREFIX_S3 = "D:/factory/sts4_4210/repo_nirey_uploaded";
	public static final String UPLOADED_PATH_PREFIX_FOR_VIEW_S3 = "/uploaded";
	
	public static final Integer COOKIE_MAXAGE_XDM = 60 * 60 * 24 * 30;	//초 * 분 * 시간 * 일 : 30day
	public static final String COOKIE_DOMAIN_XDM = "";
	public static final String COOKIE_PATH_XDM = "/";
	public static final String COOKIE_SEQ_NAME_XDM = "cookieSeqXdm";
	
	public static final String versionUiMain = "v1";
	
	public static final String SESSION_SEQ_NAME_XDM = "sessSeqXdm";
	
	
//	usr
	public static final Integer SESSION_MINUTE_USR = 30;
	
	public static final long PASSWOPRD_CHANGE_INTERVAL_USR = 90;
	
	public static final Integer COOKIE_MAXAGE_USR = 60 * 60 * 24 * 30;	//초 * 분 * 시간 * 일 : 30day
	public static final String COOKIE_DOMAIN_USR = "";
	public static final String COOKIE_PATH_USR = "/";
	public static final String COOKIE_SEQ_NAME_USR = "cookieSeqUsr";
	
	public static final String SESSION_SEQ_NAME_USR = "sessSeqUsr";
	
}
