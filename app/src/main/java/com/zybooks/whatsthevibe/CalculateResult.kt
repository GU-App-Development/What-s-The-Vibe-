package com.zybooks.whatsthevibe

import android.content.Intent


class CalculateResult {

    /*private fun authenticateSpotify() {
        val builder: AuthorizationRequest.Builder =
            Builder(CLIENT_ID, AuthorizationResponse.Type.TOKEN, REDIRECT_URI)
        builder.setScopes(arrayOf<String>(SCOPES))
        val request: AuthorizationRequest = builder.build()
        AuthorizationClient.openLoginActivity(this, REQUEST_CODE, request)
    }*/

    /*protected fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)

        // Check if result comes from the correct activity
        if (requestCode == REQUEST_CODE) {
            val response: AuthorizationResponse =
                AuthorizationClient.getResponse(resultCode, intent)
            when (response.getType()) {
                TOKEN -> {
                    editor = getSharedPreferences("SPOTIFY", 0).edit()
                    editor.putString("token", response.getAccessToken())
                    Log.d("STARTING", "GOT AUTH TOKEN")
                    editor.apply()
                    waitForUserInfo()
                }
                ERROR -> {}
                else -> {}
            }
        }
    }*/

}