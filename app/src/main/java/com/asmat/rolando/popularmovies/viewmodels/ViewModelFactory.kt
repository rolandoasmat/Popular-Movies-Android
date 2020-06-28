package com.asmat.rolando.popularmovies.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.asmat.rolando.popularmovies.model.mappers.DataModelMapper
import com.asmat.rolando.popularmovies.model.mappers.UiModelMapper
import com.asmat.rolando.popularmovies.repositories.MoviesRepository
import com.asmat.rolando.popularmovies.repositories.PeopleRepository
import com.asmat.rolando.popularmovies.ui.castdetails.CastDetailsViewModel
import com.asmat.rolando.popularmovies.ui.castdetails.personmoviecredits.PersonMovieCreditsViewModel
import com.asmat.rolando.popularmovies.ui.favoritemovies.FavoriteMoviesViewModel
import com.asmat.rolando.popularmovies.ui.moviedetails.MovieDetailsViewModel
import com.asmat.rolando.popularmovies.ui.nowplayingmovies.NowPlayingMoviesViewModel
import com.asmat.rolando.popularmovies.ui.popularmovies.PopularMoviesViewModel
import com.asmat.rolando.popularmovies.ui.search.SearchViewModel
import com.asmat.rolando.popularmovies.ui.topratedmovies.TopRatedMoviesViewModel
import com.asmat.rolando.popularmovies.ui.upcomingmovies.UpcomingMoviesViewModel
import com.asmat.rolando.popularmovies.ui.watchlatermovies.WatchLaterViewModel
import io.reactivex.android.schedulers.AndroidSchedulers

class ViewModelFactory(private val moviesRepository: MoviesRepository,
                       private val peopleRepository: PeopleRepository,
                       private val dataModelMapper: DataModelMapper,
                       private val uiModelMapper: UiModelMapper) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(PopularMoviesViewModel::class.java) -> PopularMoviesViewModel(moviesRepository, uiModelMapper, dataModelMapper) as T
            modelClass.isAssignableFrom(TopRatedMoviesViewModel::class.java) -> TopRatedMoviesViewModel(moviesRepository, uiModelMapper, dataModelMapper) as T
            modelClass.isAssignableFrom(NowPlayingMoviesViewModel::class.java) -> NowPlayingMoviesViewModel(moviesRepository, uiModelMapper, dataModelMapper) as T
            modelClass.isAssignableFrom(UpcomingMoviesViewModel::class.java) -> UpcomingMoviesViewModel(moviesRepository, uiModelMapper, dataModelMapper) as T
            modelClass.isAssignableFrom(MovieDetailsViewModel::class.java) -> MovieDetailsViewModel(moviesRepository, dataModelMapper, AndroidSchedulers.mainThread()) as T
            modelClass.isAssignableFrom(CastDetailsViewModel::class.java) -> CastDetailsViewModel(peopleRepository, AndroidSchedulers.mainThread()) as T
            modelClass.isAssignableFrom(PersonMovieCreditsViewModel::class.java) -> PersonMovieCreditsViewModel(peopleRepository, uiModelMapper, AndroidSchedulers.mainThread(), moviesRepository) as T
            modelClass.isAssignableFrom(FavoriteMoviesViewModel::class.java) -> FavoriteMoviesViewModel(moviesRepository, uiModelMapper, dataModelMapper) as T
            modelClass.isAssignableFrom(WatchLaterViewModel::class.java) -> WatchLaterViewModel(moviesRepository, uiModelMapper, dataModelMapper) as T
            modelClass.isAssignableFrom(SearchViewModel::class.java) -> SearchViewModel(moviesRepository, uiModelMapper, dataModelMapper) as T
            else -> {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }

}