-- TIEP3 Tietokantojan perusteet
-- Harjoitustyö: Liikuntakeskuksen tietokanta, kysely 3
-- Eveliina Toivanen (eveliina.toivanen@tuni.fi)

-- Haetaan tunnus ja nimi jokaiselle ohjaajalle, jotka voivat ohjata vain spinning-kategorian
-- tunteja.
SELECT ohjaaja.otunnus AS ohjtunnus, onimi AS ohjnimi
FROM voi_ohjata INNER JOIN ohjaaja ON ohjaaja.otunnus = voi_ohjata.otunnus
    INNER JOIN rltunti ON voi_ohjata.rltunnus = rltunti.rltunnus
    INNER JOIN kategoria ON kategoria.ktunnus = rltunti.ktunnus
WHERE knimi = 'Spinning'
EXCEPT
SELECT voi_ohjata.otunnus, onimi
FROM voi_ohjata INNER JOIN ohjaaja ON ohjaaja.otunnus = voi_ohjata.otunnus
    INNER JOIN rltunti ON voi_ohjata.rltunnus = rltunti.rltunnus
    INNER JOIN kategoria ON kategoria.ktunnus = rltunti.ktunnus
WHERE knimi != 'Spinning'
ORDER BY ohjtunnus;

