Here is how is it API used for this project
--------------------------------------------------------------------------------------------
============================================================================================
--------------------------------------------------------------------------------------------

You should have an api_key that you have to request before. Mine is:
1af3cebe6ba136777ed3c08d01ec7484
Read more here: https://www.themoviedb.org/talk/637d6be07d41aa007f9c6d64#637d6be07d41aa007f9c6d67

============================================================================================
To demonstrate the work of the app, I queried top rated movies of the API by the special "top_rated" query prepared by the developers of the API
and other way of a custom query with parameters. The parametrised case is described below in the p.2)
------->

1)
Here is the API documentation description of how to get one or more pages of them:
https://developers.themoviedb.org/3/movies/get-top-rated-movies

This is an example how to get them:
https://api.themoviedb.org/3/movie/top_rated?api_key=1af3cebe6ba136777ed3c08d01ec7484&language=en-US&page=1
        which consists of
            https://api.themoviedb.org/3 -------> base URL of the source location of the API
            /movie -------> source name
            /top_rated? -------> special preDeveloped query of this API
                                 and ? means multiple queries
            api_key -------> equals my api key
            &
            language -------> equals the correspondent code of a language (optional)
            &
            page -------> equals 1 just in case to show and example of the API
--------------------------------------------------------------------------------------------
2)
WE WILL USE THIS QUERY EXACTLY
Also you can get any list of movies by using a special query. Here is the API documentation description how to do that:
Here is about the difference between search/discover/find options and why we need to use here the "discover" option exactly
https://www.themoviedb.org/documentation/api
According to the instructions we have our query:
https://api.themoviedb.org/3/discover/movie?api_key=1af3cebe6ba136777ed3c08d01ec7484&page=1&sort_by=popularity.desc&vote_count.gte=20000&vote_average.gte=7
    which consists of:
        https://api.themoviedb.org/3 -------> base URL of the source location of the API
        /discover/movie? -------> source name
                                  and ? means multiple queries
        api_key=1af3cebe6ba136777ed3c08d01ec7484 -------> my API key (received before)
        &
        page=1 -------> we need only one page for the beginning
        &
        sort_by=popularity.desc -------> we need to sort the movies by popularity descending
        &
        vote_count.gte=20000 -------> we need only movies that are voted a lot - have extra many votes
        &
        vote_average.gte=7 -------> we need only movies that are voted highly - have high rating; the grade goes from 1 to 10 if ascending
============================================================================================

When you have such a link, you can check what JSON string it gets back and what objects you can work with correspondingly.
You can check it here:
http://jsonviewer.stack.hu/
On this link, there are two tabs: Text and Viewer. Just paste a link to the Text tab and then pass to the Viewer tab and you'll see the whole hierarchy.
--------------------------------------------------------------------------------------------
To get images read this:
https://developers.themoviedb.org/3/getting-started/images
    Example for the movie "The Shawshank Redemption"
    https://image.tmdb.org/t/p/w500/hBcY0fE9pfXzvVaY4GKarweriG2.jpg
        Like it is said in the documentation on the link above, we have here:
        -- https://image.tmdb.org/t/p --> base_url
        -- /w500 --> file_size
        -- /hBcY0fE9pfXzvVaY4GKarweriG2.jpg --> file_path

To get details of a single movie item, read this:
https://developers.themoviedb.org/3/getting-started/search-and-query-for-details