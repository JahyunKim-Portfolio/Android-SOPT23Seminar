package com.sopt23.seminar06.get

import com.sopt23.seminar06.data.BoardData

data class GetBoardListResponse(
        val status: Int,
        val message: String,
        val data: ArrayList<BoardData>
)