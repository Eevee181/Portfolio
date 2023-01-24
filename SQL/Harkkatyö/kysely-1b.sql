-- TIEP3 Tietokantojan perusteet
-- Harjoitustyö: Liikuntakeskuksen tietokanta, kysely 1b
-- Eveliina Toivanen (eveliina.toivanen@tuni.fi)

-- Haetaan jokaiselle Kehonhuolto-tunnille viikonpäivä, alkamisaika, nimi, kesto ja salin nimi,
-- jotka päättyvät ennen klo. 10.00 tai alkavat kello 18.00 jälkeen.
SELECT viikonpaiva, alkamisaika, rlnimi, kesto, snimi
FROM ljtunti 
    INNER JOIN rltunti ON ljtunti.rltunnus = rltunti.rltunnus
    INNER JOIN kategoria ON rltunti.ktunnus = kategoria.ktunnus
    INNER JOIN sali ON ljtunti.stunnus = sali.stunnus
WHERE (paattymisaika < '10:00:00' OR alkamisaika > '18:00:00')
	AND kategoria.ktunnus = rltunti.ktunnus
    AND knimi = 'Kehonhuolto'
ORDER BY viikonpaiva, alkamisaika, rlnimi;
