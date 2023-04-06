TRUNCATE snakes,
feedings;

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
        item
    )
VALUES
    (2000, '05/14/2022', 'Jumbo'),
    (2001, '05/28/2022', 'Jumbo'),
    (2002, '06/12/2022', 'Jumbo'),
    (2003, '06/14/2022', 'Adult'),
    (2004, '06/13/2022', 'Adult');