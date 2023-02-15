package peaksoft.service;

import peaksoft.entity.Company;

import java.util.List;

/**
 * @author kurstan
 * @created at 15.02.2023 11:57
 */
public interface CompanyService {
    void save(Company company);
    List<Company> getAllCompanies();

    Company getCompanyById(Long id);

    void deleteCompany(Long id);

    void updateCompany( Long id,Company updatedCompany);
}
