Feature: Expiration of medical

  Scenario Outline: Restrict pilots with expired medical
    Given "Patrick" is a "<class>" pilot born on "<dob>"
    When his medical has expired on "<last medical>"
    Then his license status will restricted for a period
      | new class        | <new class> |
      | restricted until | <until>     |

    Examples: First class pilot restrictions
      | class     | dob        | last medical | new class | until      | notes                           |
      | 1st class | 1990-02-10 | 2023-07-31   | 3rd class | 2028-07-31 | drop to 3rd class for 48 months |
      | 1st class | 1980-02-10 | 2023-07-31   | 2nd class | 2024-07-31 | drop to 2nd class for 6 months  |

    Examples: Second class pilot restrictions
      | class     | dob        | last medical | new class | until      | notes                           |
      | 2nd class | 1990-02-10 | 2023-07-31   | 3rd class | 2028-07-31 | drop to 3rd class for 48 months |
      | 2nd class | 1980-02-10 | 2023-07-31   | 3rd class | 2025-07-31 | drop to 3rd class for 12 months |