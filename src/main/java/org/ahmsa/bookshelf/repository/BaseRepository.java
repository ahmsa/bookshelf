package org.ahmsa.bookshelf.repository;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public class BaseRepository {
    @Inject
    protected EntityManager entityManager;
}
