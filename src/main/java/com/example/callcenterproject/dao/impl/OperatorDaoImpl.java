package com.example.callcenterproject.dao.impl;

import com.example.callcenterproject.dao.inter.OperatorDao;
import com.example.callcenterproject.entity.Operator;
import com.example.callcenterproject.exception.OperatorNotFound;
import com.example.callcenterproject.model.ExceptionResponse;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Criteria Builder for data access. Just experimental layer, not used in the project.
 */
public class OperatorDaoImpl implements OperatorDao {

    private final EntityManager em;

    public OperatorDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Operator getOperatorByUsername(String username) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Operator> cq = cb.createQuery(Operator.class);

        Root<Operator> operator = cq.from(Operator.class);
        Predicate usernamePredicate = cb.equal(operator.get("username"), username);
        cq.where(usernamePredicate);

        TypedQuery<Operator> query = em.createQuery(cq);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new OperatorNotFound(new ExceptionResponse("Operator not found", 404));
        } finally {
            em.close();
        }
    }
}
