package com.example.englishdictionary.feature_dictionary.data.repository


import android.app.Application
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.example.englishdictionary.feature_dictionary.data.model.api.DictionaryApi
import com.example.englishdictionary.feature_dictionary.data.model.mapper.toWordItem
import com.example.englishdictionary.feature_dictionary.domain.model.WordItem
import com.example.englishdictionary.feature_dictionary.domain.repository.DictionaryRepository
import retrofit2.HttpException
import java.io.IOException
import com.example.englishdictionary.util.Result


class DictionaryRepositoryImpl @Inject constructor(
    private val dictionaryApi: DictionaryApi
): DictionaryRepository {
    override suspend fun getWordResult(
        word: String
    ): Flow<Result<WordItem>> {
        return flow {
            emit(Result.Loading(true))

            val remoteWordResultDto = try {
                dictionaryApi.getWordResult(word)
            }catch (e:HttpException){                       //Http exception
                e.printStackTrace()
                emit(Result.Error("Can not get result"))
                emit(Result.Loading(false))
                return@flow
            }catch (e:IOException){                         //IO Exception
                e.printStackTrace()
                emit(Result.Error("Can not get result"))
                emit(Result.Loading(false))
                return@flow
            }catch (e:Exception){                           //Catch all exception
                e.printStackTrace()
                emit(Result.Error("Can not get result"))
                emit(Result.Loading(false))
                return@flow
            }

            remoteWordResultDto?.let { wordResultDto ->
                wordResultDto[0]?.let {wordItemDto ->
                    emit(Result.Success(wordItemDto.toWordItem()))
                    emit(Result.Loading(false))
                    return@flow
                }
            }

            emit(Result.Loading(false))
        }
    }
}