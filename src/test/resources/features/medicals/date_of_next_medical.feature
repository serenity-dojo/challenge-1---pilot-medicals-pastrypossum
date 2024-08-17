Feature: Date of next medical

  Scenario Outline: Frequency of pilot medical

    Given "Patrick" is a "<class>" pilot born on "<dob>"
    When his last medical was "<last medical>"
    Then his next medical should be "<next medical>"

    Examples: Pilots under 40 require a regular medical
      | class     | dob        | last medical | next medical | notes           |
      | 1st class | 1990-02-10 | 2024-05-31   | 2025-05-31   | every 12 months |
      | 2nd class | 1990-02-10 | 2024-05-31   | 2025-05-31   | every 12 months |
      | 3rd class | 1990-02-10 | 2024-05-31   | 2029-05-31   | every 60 months |

    Examples: Pilots over 40 require a more frequent medical
      | class     | dob        | last medical | next medical | notes           |
      | 1st class | 1975-02-10 | 2024-05-31   | 2024-11-30   | every 6 months  |
      | 2nd class | 1975-02-10 | 2024-05-31   | 2025-05-31   | every 12 months |
      | 3rd class | 1975-02-10 | 2024-05-31   | 2026-05-31   | every 24 months |

    Examples: Transition to new schedule at 40
      | class     | dob        | last medical | next medical | notes               |
      | 1st class | 1984-05-12 | 2024-04-30   | 2024-10-31   | switch to 6 months  |
      | 2nd class | 1984-05-12 | 2024-04-30   | 2025-04-30   | switch to 12 months |
      | 3rd class | 1984-05-12 | 2024-04-30   | 2026-04-30   | switch to 24 months |
