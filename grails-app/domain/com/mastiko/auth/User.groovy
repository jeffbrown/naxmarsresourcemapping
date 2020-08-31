package com.mastiko.auth

import grails.rest.Resource

@Resource(uri = '/api/users', formats=['json'])
class User implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    String memsAsterisksApiUser
    String memsAsterisksApiPassword
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
    }

    static mapping = {
        password column: '`password`'
    }
}
