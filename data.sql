TRUNCATE snakes,
feedings,
weights,
sheds,
notes;
feeding_override;

INSERT INTO
    snakes(
        id,
        owner,
        name,
        breeder_id,
        img_url,
        gender
    )
VALUES
    (
        1000,
        'Parnell',
        'Bean',
        'AA-19-01',
        'https://ik.imagekit.io/psteide/WDiM4AX_l-GpKiH0H.jpg',
        'Female'
    ),
    (
        1001,
        'Parnell',
        'Sprout',
        'AA-20-01',
        'https://ik.imagekit.io/psteide/Y8xh29a_cZnwocfuB.jpg',
        'Female'
    ),
    (
        1002,
        'Parnell',
        'Ozymandias',
        'AA-20-02',
        'https://ik.imagekit.io/psteide/ijzzJ8z_8oDB3DHtj.jpg',
        'Male'
    );

    INSERT INTO
        snakes(
            id,
            owner,
            name,
            breeder_id,
            img_url,
            gender
        )
        VALUES
    (
        1003,
        'Parnell',
        'Esme',
        'BO-22-13',
        'https://ik.imagekit.io/psteide/ijzzJ8z_8oDB3DHtj.jpg',
        'Female'
    ),
    (1004,
        'Parnell',
        'Yarrow',
        'BO-22-05',
        'https://ik.imagekit.io/psteide/ijzzJ8z_8oDB3DHtj.jpg',
        'Male'
        );


INSERT INTO
    feedings(
        id,
        date,
        item,
        snake_id
    )
VALUES
    (2000, '03/11/2023', 'Jumbo', 1000),
    (2001, '03/25/2023', 'Jumbo', 1000),
    (2002, '04/09/2023', 'Jumbo', 1000),
    (2003, '06/14/2023', 'Adult', 1002),
    (2004, '06/13/2023', 'Adult', 1001);

INSERT INTO
    weights(
        id,
        date,
        weight,
        snake_id
    )
VALUES
    (4000, '03/24/2023', 500, 1000),
    (4001, '04/03/2023', 513, 1000),
    (4002, '04/11/2023', 535, 1000),
    (4003, '06/12/2023', 400, 1001),
    (4004, '06/12/2023', 305, 1002);

INSERT INTO
    sheds(
        id,
        date,
        observation,
        snake_id
    )
VALUES
    (3000, '02/23/2023', 'Noticed', 1000),
    (3001, '03/10/2023', 'Shed', 1000),
    (3002, '04/08/2023', 'Shed', 1000);

INSERT INTO
    notes(
        id,
        date,
        note,
        snake_id
    )
VALUES
    (
        5000,
        '03/01/2023',
        'Suspected she maybe gravid again',
        1000
    ),
    (
        5001,
        '04/08/2023',
        'Just laid her second clutch of eggs, 13 eggs total, but only 3 fertile. Currently in her post-lay shed',
        1000
    ),
    (
        5002,
        '06/10/2023',
        'Seemed extra defensive the last time she has handled',
        1001
    ),
    (
        5003,
        '06/12/2023',
        'Extra active during the day',
        1002
    );

INSERT INTO
    feeding_override(
        id,
        frequency_override,
        meal_size,
        size_override,
        frequency,
        snake_id
    )
VALUES
    (
        6000,
        false,
        null,
        false,
        null,
        1000
    ),
    (
        6001,
                false,
                null,
                false,
                null,
                1001
    ),
    (
        6002,
                false,
                null,
                false,
                null,
                1002
    ),
    (
        6003,
                false,
                null,
                false,
                null,
                1003
    );
