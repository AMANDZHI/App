//package com.company.repository;
//
//import com.company.api.Repository;
//import com.company.model.Project;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import javax.persistence.TypedQuery;
//import java.util.List;
//import java.util.Optional;
//
//public class ProjectRepositoryImpl implements Repository<String, Project> {
//    private final EntityManager entityManager;
//
//    public ProjectRepositoryImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public void save(Project object) {
//        entityManager.persist(object);
//    }
//
//    @Override
//    public Optional<Project> findByName(String name) {
//        Query query = entityManager.createQuery("from Project where name = :name");
//        query.setParameter("name", name);
//        Project project = (Project)query.getSingleResult();
//        return Optional.of(project);
//    }
//
//    @Override
//    public Optional<Project> findById(String id) {
//        Project project = entityManager.find(Project.class, id);
//        return Optional.of(project);
//    }
//
//    @Override
//    public Project update(Project object) {
//        return entityManager.merge(object);
//    }
//
//    @Override
//    public void removeByName(String name) {
//        Optional<Project> findProject = findByName(name);
//        entityManager.remove(findProject.get());
//    }
//
//    @Override
//    public List<Project> getList() {
//        Query query = entityManager.createQuery("from Project");
//        return (List<Project>) query.getResultList();
//    }
//}
