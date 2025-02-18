package org.example2.testdemo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.example2.testdemo.dto.UserDTO;
import org.example2.testdemo.service.UserService;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class UserServiceIMPL implements UserService {
    private static final String WEAVY_BASE_URL = "https://dc0997f95e5a434a885ae24ad75ab2f5.weavy.io/api/users";
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

    public String getAllUsers() throws IOException {
        Request request = new Request.Builder()
                .url(WEAVY_BASE_URL)
                .get()
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    public String deleteUser(String id) throws IOException {
        Request request = new Request.Builder()
                .url(WEAVY_BASE_URL+ "/" + id+ "/trash")
                .post(RequestBody.create("", null))
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    public String updateUser(String id, UserDTO userDTO) throws IOException{
        System.out.println(userDTO.getEmail());
        MediaType JSON = MediaType.get("application/json; charset=utf-8");

        okhttp3.RequestBody body = RequestBody.create(
                new ObjectMapper().writeValueAsString(userDTO), JSON
        );

        Request request = new Request.Builder()
                .url(WEAVY_BASE_URL+ "/" + id)
                .put(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
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
