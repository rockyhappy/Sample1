package com.devrachit.swiggy_xml_imdb.presentation.details_screen

import com.devrachit.swiggy_xml_imdb.data.remote.dto.Title

data class DetailUiState (
    val isLoading: Boolean ? = false,
    val title : Title ? = null,
)
