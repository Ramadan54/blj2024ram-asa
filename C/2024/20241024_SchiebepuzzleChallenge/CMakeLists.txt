cmake_minimum_required(VERSION 3.29)
project(20241024_SchiebepuzzleChallenge)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(20241024_SchiebepuzzleChallenge
    aufgabenstellung.txt
    main.c
    utils.c
    utils.h)
