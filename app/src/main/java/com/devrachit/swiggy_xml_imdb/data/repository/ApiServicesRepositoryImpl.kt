package com.devrachit.swiggy_xml_imdb.data.repository

import com.devrachit.swiggy_xml_imdb.data.remote.dto.SearchReasultDto
import com.devrachit.swiggy_xml_imdb.data.remote.services.ApiServices
import com.devrachit.swiggy_xml_imdb.domain.repository.ApiServicesRepository
import javax.inject.Inject
import android.util.Log
import com.devrachit.swiggy_xml_imdb.data.remote.dto.Title

class ApiServicesRepositoryImpl @Inject constructor(
    private val api: ApiServices
) : ApiServicesRepository {
    override suspend fun searchTitles(title: String): SearchReasultDto {
        val response = api.searchTitles(title)
        return response
    }

    override suspend fun getTitleDetails(imdbId: String): Title {
        val response = api.getTitleDetails(imdbId)
        return response
    }
}