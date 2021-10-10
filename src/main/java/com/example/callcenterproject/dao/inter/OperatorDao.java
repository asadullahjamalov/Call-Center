package com.example.callcenterproject.dao.inter;

import com.example.callcenterproject.entity.Operator;

/**
 * Criteria Builder for data access. Just experimental layer, not used in the project.
 */
public interface OperatorDao {
    Operator getOperatorByUsername(String username);
}
