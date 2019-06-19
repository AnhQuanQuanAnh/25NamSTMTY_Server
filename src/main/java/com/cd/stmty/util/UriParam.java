package com.cd.stmty.util;

public interface UriParam {

    /**
     * URL COMMON
     */
    String FORWARD_SLASH = "/";
    String LIST = "";
    String ID = "id";
    String GET = "/{id}";
    String SEARCH = "/search";
    String INSERT = "/insert";
    String UPDATE = "/update";
    String DELETE = "/delete";
//    String GET_WITH_ID = "/%s";
    String DOWNLOAD = "/download";
    String IMPORT = "/import";
    String READ_CSV = "/read-csv";
    String EXPORT = "/export";
    String IMPORT_FILE = "importFile";
    String DELETE_SET = "/delete-set";
    String SEARCH_KEY = "searchKey";
    String UPLOAD_IMAGE = "/upload-image";
    String DELETE_IMAGE = "/delete-image";
    String KEY_IMAGE = "key";
    String TIME_ZONE = "timeZone";

    /**
     * URL Post
     */
    String POST = "/post";
    String GET_WITH_ID = "/tin-tuc/{id}";

    /**
     * URL User
     */
    String USER = "/user";
    String GET_WITH_USER_NAME = "/{userName}";
}
