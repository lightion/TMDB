package tech.lightion.tmdb.model

object TempDataList {

    val movieList = ArrayList<Movie>()

    init {
        movieList.add(
            Movie(
                0,
                "Extraction",
                "Drama, Action, Thriller",
                "04/24/2020",
                75,
                "Tyler Rake, a fearless mercenary who offers his services on the black market, embarks on a dangerous mission when he is hired to rescue the kidnapped son of a Mumbai crime lord…",
                ""
            )
        )
        movieList.add(
            Movie(
                1,
                "Inception",
                "Adventure, Fantasy, Action",
                "07/16/2010",
                83,
                "Cobb, a skilled thief who commits corporate espionage by infiltrating the subconscious of his targets is offered a chance to regain his old life as payment for a task considered to be impossible: \"inception\", the implantation of another person's idea into a target's subconscious.",
                ""
            )
        )
        movieList.add(
            Movie(
                2,
                "The Lord of the Rings: The Fellowship of the Ring",
                "Drama, Action, Thriller",
                "12/19/2001",
                83,
                "Young hobbit Frodo Baggins, after inheriting a mysterious ring from his uncle Bilbo, must leave his home in order to keep it from falling into the hands of its evil creator. Along the way, a fellowship is formed to protect the ringbearer and make sure that the ring arrives at its final destination: Mt. Doom, the only place where it can be destroyed.",
                ""
            )
        )
        movieList.add(
            Movie(
                3,
                "Once Upon a Time… in Hollywood",
                "Comedy, Drama, Thriller",
                "07/26/2019",
                75,
                "Tyler Rake, a fearless mercenary who offers his services on the black market, embarks on a dangerous mission when he is hired to rescue the kidnapped son of a Mumbai crime lord…"
            )
        )
        movieList.add(
            Movie(
                4,
                "Parasite",
                "Comedy, Thriller, Drama",
                "11/01/2019",
                85,
                "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident."
            )
        )
        movieList.add(
            Movie(
                5,
                "Jumanji: The Next Level",
                "Adventure, Comedy, Fantasy",
                "12/13/2019",
                69,
                "As the gang return to Jumanji to rescue one of their own, they discover that nothing is as they expect. The players will have to brave parts unknown and unexplored in order to escape the world’s most dangerous game."
            )
        )
        movieList.add(
            Movie(
                6,
                "Spider-Man: Far from Home",
                "Action, Adventure, Science Fiction",
                "07/02/2019",
                75,
                "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent."
            )
        )
        movieList.add(
            Movie(
                7,
                "Avengers: Infinity War",
                "Adventure, Action, Science Fiction",
                "04/27/2018",
                83,
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."
            )
        )
        movieList.add(
            Movie(
                8,
                "Interstellar",
                "Adventure, Drama, Science Fiction",
                "11/07/2014",
                83,
                "Interstellar chronicles the adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage."
            )
        )
        movieList.add(
            Movie(
                9,
                "Harry Potter and the Philosopher's Stone",
                "Adventure, Fantasy, Family",
                "11/16/2001",
                79,
                "Harry Potter has lived under the stairs at his aunt and uncle's house his whole life. But on his 11th birthday, he learns he's a powerful wizard -- with a place waiting for him at the Hogwarts School of Witchcraft and Wizardry. As he learns to harness his newfound powers with the help of the school's kindly headmaster, Harry uncovers the truth about his parents' deaths -- and about the villain who's to blame."
            )
        )

    }

    fun updateMovieTitle(movie: Movie, title: String) {
        movieList.forEach {
            if (it.id == movie.id) {
                it.title = title
            }
        }
    }

}