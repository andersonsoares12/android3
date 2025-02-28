

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mundoti.rickandortyvideo.models.RickMorty

class RickMortyPagingSource(
    private val apiService: ApiService
):PagingSource<Int , RickMorty>(){

    override fun getRefreshKey(
        state : PagingState<Int , RickMorty>
    ) : Int? {
        return null
    }

    override suspend fun load(
        params : LoadParams<Int>)
            : LoadResult<Int , RickMorty> {

        return try {
            val currentPage = params.key?:1
            val response = apiService.getAllCharacters(currentPage)
            val data =response.body()?.results?:emptyList()
            val responseData = mutableListOf<RickMorty>()
            responseData.addAll(data)
            Log.d("RickMortyPagingSource", "Loaded ${data.size} items from page $currentPage")
            LoadResult.Page(
                data = responseData,
                prevKey = if(currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        }catch (e:Exception){
            Log.e("RickMortyPagingSource", "Error loading data", e)
            LoadResult.Error(e)
        }
    }
}