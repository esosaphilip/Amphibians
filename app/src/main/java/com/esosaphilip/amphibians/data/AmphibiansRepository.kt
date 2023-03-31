package com.esosaphilip.amphibians.data

import com.esosaphilip.amphibians.network.AmphibiansApiService
import com.esosaphilip.amphibians.network.Amphim
import com.esosaphilip.amphibians.network.AmphimItem
import retrofit2.Call

interface AmphibiansRepository {
suspend fun getAmphibiansDatas(): List<AmphimItem>
}

class DefaultAmphibiansRepository(private val amphibiansApiService: AmphibiansApiService): AmphibiansRepository{

    override suspend fun getAmphibiansDatas(): List<AmphimItem> = amphibiansApiService.getDatas()


}