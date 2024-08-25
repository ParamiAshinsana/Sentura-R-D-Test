package org.example2.testdemo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.example2.testdemo.dto.UserDTO;
import org.example2.testdemo.service.UserService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;



@Service

@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
    private static final String WEAVY_BASE_URL = "https://dc0997f95e5a434a885ae24ad75ab2f5.weavy.io";
    private static final String API_KEY = "wys_PRXM813kZwCMujWqC2BEDw5Ioh9CKf1MdLXg";

    private final OkHttpClient client = new OkHttpClient();


    @Override
    public String createUser(UserDTO userDTO) throws IOException {
        System.out.println(userDTO.getEmail());
        MediaType JSON = MediaType.get("application/json; charset=utf-8");

        okhttp3.RequestBody body = RequestBody.create(
                new ObjectMapper().writeValueAsString(userDTO), JSON
        );

        Request request = new Request.Builder()
                .url(WEAVY_BASE_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    public List<UserDTO> getAllUser() {
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public void updateUser(String id, UserDTO userDTO) {

    }

    @Override
    public String getUserById(String id) throws IOException {
        Request request = new Request.Builder()
                .url(WEAVY_BASE_URL + "/" + id)
                .get()
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
        }
}
