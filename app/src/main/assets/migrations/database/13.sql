UPDATE PASSE SET exact=1
WHERE _id IN (SELECT DISTINCT p._id
  FROM PASSE p, SHOOT s
  WHERE p._id=s.passe
  AND s.x!=0);
ALTER TABLE TRAINING ADD COLUMN exact INTEGER DEFAULT 0;
UPDATE TRAINING SET exact=1
WHERE _id IN (SELECT DISTINCT t._id
  FROM TRAINING t, ROUND r, PASSE p
  WHERE t._id=r.training
  AND r._id=p.round
  AND p.exact=1);