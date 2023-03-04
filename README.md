# BracketBreaker
## What is this?
BracketBreaker is a program that can generate March Madness brackets based on a rating system of the field of 64 teams. It can be customized (only in the source code for now) to work with any single-elimination bracket system without reseeding. It's designed to be both fast and accurate.

## Algorithm
BracketBreaker runs Monte Carlo simulations of the tournament, using probabilities based on the inputted ratings to simulate billions of tournament outcomes and create brackets. It can generate and store about 750,000 brackets per second per thread, depending on the CPU of the computer.

## Storage
To make storage as efficient as possible, each bracket is stored directly using binary, requiring only 8 bytes each. This makes it so anyone can store billions of brackets easily.

## Analysis
Analysis of the files will be implemented before the Selection Sunday of the 2023 March Madness Tournament.

# Comparisons
These comparisons assume the same rules as typical bracket challenge websites: that is, only considering the 63 matches after the First Four. They also assume a speed of 3,000,000 brackets per second, which is achievable using 4 threads. They also assume that you have average luck.

Note that an accuracy of about 2/3 is typical when generating brackets, and that the accuracy of models varies from year to year.

| Accuracy | Brackets Needed | Time Needed | Space Needed
| - | - | - | - |
| 50% | 9,223,372,036,854,775,808 | 97,940 years | 64.0 EB
| 60% | 94,726,442,144,560 | 1.00 years | 689 TB
| 66.67% | 124,093,581,920 | 11.5 hrs | 925 GB
| 71.97% | 1,000,000,000 | 5.6 mins | 7.5 GB
| 75% | 74,325,939 | 24.8 s | 9.72 MB
| 80% | 1,274,473 | 0.4 s | 10.2 MB
| 90% | 763 | 0.25 ms | 6.1 KB