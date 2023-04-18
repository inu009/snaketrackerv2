TRUNCATE
feedings,
weights,
sheds,
notes;


INSERT INTO
    feedings(
        id,
        date,
        item,
        snake_id
    )
VALUES
    (2000000, '03/19/2023', 'Adult', 1),
    (2000001, '04/02/2023', 'Adult', 1),
    (2000002, '04/16/2023', 'Adult', 1),
    (2000003, '03/19/2023', 'Adult', 2),
    (2000004, '04/02/2023', 'Adult', 2),
    (2000005, '04/16/2023', 'Adult', 2),
    (2000006, '03/19/2023', 'Adult', 3),
    (2000007, '04/02/2023', 'Adult', 3),
    (2000008, '04/16/2023', 'Adult', 3),
    (2000009, '04/17/2023', 'Hopper', 4),
    (2000010, '06/17/2023', 'Hopper', 5);

INSERT INTO
    weights(
        id,
        date,
        weight,
        snake_id
    )
VALUES
    (4000000, '04/18/2023', 500, 1),
    (4000001, '04/18/2023', 513, 2),
    (4000002, '04/18/2023', 535, 3),
    (4000003, '04/18/2023', 60, 4),
    (4000004, '04/18/2023', 60, 5);

INSERT INTO
    sheds(
        id,
        date,
        observation,
        snake_id
    )
VALUES
    (3000000, '04/18/2023', 'Noticed', 3);

INSERT INTO
    notes(
        id,
        date,
        note,
        snake_id
    )
VALUES
    (
        5000000,
        '04/18/2023',
        'Finally has calmed down from the breeding season, did not lose appetite this year',
        1
    ),
    (
       5000001,
       '04/18/2023',
       'No longer food shy',
       5

    ),
    (
        5000002,
        '04/18/2023',
        'Extra active during the day and late evening',
        3
    );