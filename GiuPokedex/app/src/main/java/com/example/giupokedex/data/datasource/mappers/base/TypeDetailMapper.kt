package com.example.giupokedex.data.datasource.mappers.base

import com.example.giupokedex.data.datasource.remote.modelresponse.base.TypeDetailResponse
import com.example.giupokedex.domain.models.base.TypeDetail

fun TypeDetailResponse.toTypeDetailDomainModel() = TypeDetail(
    id = id ?: 0,
    name = name.orEmpty()
)