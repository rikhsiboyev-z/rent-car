create table car
(
    id                uuid      default gen_random_uuid(),
    model             varchar(255) not null,
    price             int,
    engine            varchar(255),
    transmission      varchar,
    weight            varchar,
    dynamicIndicators varchar,
    FuelConsumption   varchar,
    available         bool,
    pathImg           varchar,
    pickupDate        timestamp default null,
    returnDate        timestamp default null
);

insert into car(model, price, engine, transmission, weight,
                dynamicIndicators, FuelConsumption, available, pathImg)
values ('ChevroletDamas', 350, 'максимальная скорость - 105 км/ч, разгон до 100 км/ч - 41 секунда.',
        'в городском цикле - 8,6 л, при смешанном цикле - 7,8 л. Объем бака составляет 37 литров. Рекомендуемый к использованию бензин - АИ-91.',
        'рядный трехцилиндровый объемом 796 куб.см. Максимальная мощность - 38 л.с.',
        'пятиступенчатая механическая коробка передач с задним приводом.',
        'снаряженная - 850 кг, максимально разрешенная - 1360 кг.', false,
        'https://avtoremont.uz/thumb/2/VU2bkX2QHAHL0vzR_ZSmqg/r/d/gm_uzbekistan_damas.jpg');

--        ('ChevroletSpark', 400, '', '', '', '', '', false,
--         'https://avtoremont.uz/thumb/2/sqrb4FqgDSAOPGRpMzfotg/r/d/gm_uzbekistan_spark.jpg'),
--        ('ChevroletCobalt', 450, '', '', '', '', '', false,
--         'https://avtoremont.uz/thumb/2/7X6XNO7Htty9fLoDkfiOAQ/r/d/gm_uzbekistan_cobalt.jpg'),
--        ('ChevroletNexia3', 500, '', '', '', '', '', false,
--         'https://avtoremont.uz/thumb/2/woHEvOxIAxkQmROM6uUEvw/r/d/gm_uzbekistan_nexia-3.jpg'),
--        ('ChevroletLacetti', 550, '', '', '', '', '', false,
--         'https://avtoremont.uz/thumb/2/9I1aqbE2AX9hS321BcwNEg/r/d/gm_uzbekistan_lacetti.jpg'),
--        ('ChevroletTracker2', 600, '', '', '', '', '', false,
--         'https://avtoremont.uz/d/2022-chevrolet-tracker-2.jpg'),
--        ('ChevroletMalibu2Turbo, 650, ', '', '', '', '', false,
--         'https://avtoremont.uz/thumb/2/7wzOJNx02vUsy30h_q9hbQ/r/d/gm_uzbekistan_malibu.jpg'),
--        ('ChevroletCaptiva, 700, ', '', '', '', '', false,
--         'https://avtoremont.uz/thumb/2/D5-1URyVvDZ9bjNoQpm-VQ/r/d/gm_uzbekistan_captiva.jpg'),
--        ('ChevroletTrailblazer, 750, ', '', '', '', '', false,
--         'https://avtoremont.uz/d/gm-uzbekistan-trailblazer.jpg'),
--        ('ChevroletEquinox2', 800, '', '', '', '', '', false,
--         'https://avtoremont.uz/d/gm-uzbekistan-equinox.jpg'),
--        ('ChevroletTraverse', 850, '', '', '', '', '', false,
--         'https://avtoremont.uz/d/2023-chevrolet-traverse-2.jpg'),
--        ('ChevroletTahoe', 900, '', '', '', '', '', false,
--         'https://avtoremont.uz/d/chevrolet-tahoe-2022.jpg');