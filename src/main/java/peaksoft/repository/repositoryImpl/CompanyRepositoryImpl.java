package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Company;
import peaksoft.repository.CompanyRepository;

import java.util.List;

/**
 * @author kurstan
 * @created at 15.02.2023 11:56
 */
@Repository
@Transactional
public class CompanyRepositoryImpl implements CompanyRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Company company) {
        entityManager.persist(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return entityManager.createQuery("from Company ", Company.class).getResultList();
    }

    @Override
    public Company getCompanyById(Long id) {
        return entityManager.createQuery("from Company where id =: id", Company.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public void deleteCompany(Long id) {
        entityManager.createQuery("delete from Company where id =: id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void updateCompany(Long id, Company updatedCompany) {
        entityManager.createQuery(
                "update Company set name = :n, image = :i," +
                        " email = :e where id = :id")
                .setParameter("n", updatedCompany.getName())
                .setParameter("i", updatedCompany.getImage())
                .setParameter("e", updatedCompany.getEmail())
                .setParameter("id", id)
                .executeUpdate();
    }
}
