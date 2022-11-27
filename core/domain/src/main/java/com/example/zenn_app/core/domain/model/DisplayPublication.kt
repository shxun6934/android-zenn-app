package com.example.zenn_app.core.domain.model

data class DisplayPublication(
    val id: Int,
    val displayName: String,
    val avatarSmallUrl: String?
) {
    companion object {
        fun dummy(): DisplayPublication = DisplayPublication(
            id = 1,
            displayName = "test_publication",
            avatarSmallUrl = "https://res.cloudinary.com/zenn/image/fetch/s--2AJvJ3Nr--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_50/https://storage.googleapis.com/zenn-user-upload/avatar/e630118035.jpeg"
        )
    }
}
