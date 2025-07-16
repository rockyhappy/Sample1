package com.devrachit.swiggy_xml_imdb.domain.repository

import com.devrachit.swiggy_xml_imdb.data.remote.dto.SearchReasultDto
import com.devrachit.swiggy_xml_imdb.data.remote.dto.Title
import retrofit2.Response

interface ApiServicesRepository
{
    suspend fun searchTitles(title:String) : SearchReasultDto

    suspend fun getTitleDetails(imdbId:String) : Title
}