TRUNCATE TABLE car RESTART IDENTITY;

INSERT INTO car (make, model, year, price, stock, image_url, created_at) VALUES
                                                                             ('BMW','M3',2022, 79900, 3, 'https://hips.hearstapps.com/hmg-prod/images/2022-bmw-m3-competition-xdrive-110-1618601677.jpg?crop=0.673xw:0.567xh;0.00962xw,0.264xh&resize=1200:*', now()),
                                                                             ('Audi','A4',2021, 39900, 5, 'https://assets.comparis.ch/image/upload/s--6HRbFoqY--/f_auto,q_auto/v1/carfinder/Images/DataCollect/ed97ce64-706b-c86d-4dd8-bfb49b50a841.jpg', now()),
                                                                             ('Tesla','Model 3',2023, 45900, 4, 'https://assets.comparis.ch/image/upload/s--wcmPUHIX--/f_auto,q_auto/v1/carfinder/Images/DataCollect/27263d53-39e3-7210-0ba2-8b002bbe6e31.jpg', now());
