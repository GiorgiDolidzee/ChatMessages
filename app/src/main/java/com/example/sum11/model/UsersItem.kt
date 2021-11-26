package com.example.sum11.model


import com.google.gson.annotations.SerializedName

data class UsersItem(
    @SerializedName("avatar")
    val avatar: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("is_typing")
    val isTyping: Boolean?,
    @SerializedName("last_message")
    val lastMessage: String?,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("message_type")
    val messageType: String?,
    @SerializedName("unrea_message")
    val unreaMessage: Int?,
    @SerializedName("updated_date")
    val updatedDate: Long?
)