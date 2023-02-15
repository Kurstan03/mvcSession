package peaksoft.repository;

import peaksoft.entity.Company;

import java.awt.image.ConvolveOp;
import java.util.List;

/**
 * @author kurstan
 * @created at 15.02.2023 11:55
 */
public interface CompanyRepository {
    void save(Company company);
    List<Company> getAllCompanies();

    Company getCompanyById(Long id);

    void deleteCompany(Long id);

    void updateCompany( Long id,Company updatedCompany);
}
