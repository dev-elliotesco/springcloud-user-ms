package com.user.ms.controller.docs;

import com.user.ms.model.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Tag(name = "User controller", description = "API exposed to manage users")
public interface UserDoc {


    @Operation(summary = "Create user", description = "This operation is for create a new user in the system")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "User created",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity);

    @Operation(summary = "Get all users", description = "This operation is for get all users in the system")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Users found",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "204",
                    description = "No users found",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    ResponseEntity<List<UserEntity>> getAllUsers();

    @Operation(summary = "Get user by id", description = "This operation is for get a user by id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "User found",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "User not found",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    ResponseEntity<UserEntity> getUserById(@PathVariable String id);

    @Operation(summary = "Update user", description = "This operation is for update a user by id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "User updated",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "User not found",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    ResponseEntity<UserEntity> updateUser(@PathVariable String id, @RequestBody UserEntity userEntity);

    @Operation(summary = "Delete user", description = "This operation is for delete a user by id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "User deleted",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "User not found",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    ResponseEntity<Void> deleteUser(@PathVariable String id);
}
