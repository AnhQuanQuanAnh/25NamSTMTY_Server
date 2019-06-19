package com.cd.stmty.api;

import com.cd.stmty.model.ApiResponse;
import com.cd.stmty.model.BaseListRequest;
import com.cd.stmty.model.Post;
import com.cd.stmty.util.UriParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping(value = UriParam.POST)
public interface PostApi {

    @RequestMapping(value = UriParam.FORWARD_SLASH, method = RequestMethod.GET)
    ApiResponse<Page<Post>> list(BaseListRequest request);

    @RequestMapping(value = UriParam.INSERT, method = RequestMethod.POST)
    ApiResponse<Post> insert(@RequestBody Post post);

    @RequestMapping(value = UriParam.UPDATE, method = RequestMethod.POST)
    ApiResponse<Post> update(@RequestBody Post post);

    @RequestMapping(value = UriParam.DELETE, method = RequestMethod.POST)
    ApiResponse<Boolean> delete(Long postId);

    @RequestMapping(value = UriParam.GET_WITH_ID, method = RequestMethod.GET)
    ApiResponse<Post> getById(@PathVariable(value = UriParam.ID) Long id);
}
