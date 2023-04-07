TRUNCATE snakes,
feedings,
weights;

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
    feedings(
        id,
        date,
        item,
        snake_id
    )
VALUES
    (2000, '05/14/2022', 'Jumbo', 1000),
    (2001, '05/28/2022', 'Jumbo', 1000),
    (2002, '06/12/2022', 'Jumbo', 1000),
    (2003, '06/14/2022', 'Adult', 1000),
    (2004, '06/13/2022', 'Adult', 1001);

INSERT INTO
    weights(
        id,
        date,
        weight,
        snake_id
    )
VALUES
    (4000, '05/24/2022', 500, 1000),
    (4001, '06/01/2022', 513, 1000),
    (4002, '06/12/2022', 535, 1000),
    (4003, '06/12/2022', 400, 1001),
    (4004, '06/12/2022', 305, 1002);