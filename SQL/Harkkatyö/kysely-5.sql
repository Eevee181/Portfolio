-- TIEP3 Tietokantojan perusteet
-- Harjoitustyö: Liikuntakeskuksen tietokanta, kysely 5
-- Eveliina Toivanen (eveliina.toivanen@tuni.fi)

-- Haetaan tunnukset ja nimet ohjaajille, jotka ohjaavat kaikkien niiden ryhmäliikuntatuntien
-- lukujärjestystunteja, joita he voivat ohjata.
SELECT ohjaaja.otunnus, onimi
FROM ohjaaja
WHERE NOT EXISTS (SELECT rltunnus
                  FROM voi_ohjata
				  WHERE ohjaaja.otunnus = voi_ohjata.otunnus
				  EXCEPT
				  SELECT rltunnus
				  FROM ljtunti
				  WHERE ohjaaja.otunnus = ljtunti.otunnus)
ORDER BY otunnus;