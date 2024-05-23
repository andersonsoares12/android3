import com.mundoti.rickandortyvideo.models.ResponseApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getAllCharacters(@Query("page") page: Int): Response<ResponseApi>
}
