begin transaction;

UPDATE destinations
SET website = 'http://www.ohiocity.org/west-side-market'
WHERE name = 'West Side Market';

commit;