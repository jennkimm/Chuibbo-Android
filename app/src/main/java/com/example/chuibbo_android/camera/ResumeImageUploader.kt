package com.example.chuibbo_android.camera

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class ResumeImageUploader {
//    suspend fun upload(imageFile: File) = try {
//        withContext(Dispatchers.IO) {
//            val part = makeImagePart(imageFile)
//            ImageApi.instance.uploadResumePhoto(part)
//        }
//    } catch (e: Exception) {
//        error("error: product image upload")
//        ApiResponse.error<ResumePhotoUploadResponse>(
//            "An unknown error has occurred."
//        )
//    }

    private fun makeImagePart(imageFile: File): MultipartBody.Part {
        val mediaType = "multipart/form-data".toMediaType()
        val body = imageFile.asRequestBody(mediaType)

        return MultipartBody.Part
            .createFormData("photo", imageFile.name, body)
    }
}
