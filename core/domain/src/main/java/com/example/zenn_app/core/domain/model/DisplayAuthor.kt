package com.example.zenn_app.core.domain.model

data class DisplayAuthor(
    val id: Int,
    val displayName: String,
    val avatarSmallUrl: String?
) {
    companion object {
        fun dummy(): DisplayAuthor = DisplayAuthor(
            id = 1,
            displayName = "test_user",
            avatarSmallUrl = "https://res.cloudinary.com/zenn/image/fetch/s--7cfX2iFd--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_70/https://storage.googleapis.com/zenn-user-upload/avatar/9b16aead3e.jpeg"
        )
    }
}
