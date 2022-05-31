/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ti.enterprise.project.KTP;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ti.enterprise.project.KTP.exceptions.NonexistentEntityException;
import ti.enterprise.project.KTP.exceptions.PreexistingEntityException;

/**
 *
 * @author weann
 */
public class DataKtpJpaController implements Serializable {

    public DataKtpJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ti.enterprise_project.KTP_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public DataKtpJpaController() {
    }

    
    
    public void create(DataKtp dataKtp) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(dataKtp);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDataKtp(dataKtp.getId()) != null) {
                throw new PreexistingEntityException("DataKtp " + dataKtp + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DataKtp dataKtp) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            dataKtp = em.merge(dataKtp);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = dataKtp.getId();
                if (findDataKtp(id) == null) {
                    throw new NonexistentEntityException("The dataKtp with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DataKtp dataKtp;
            try {
                dataKtp = em.getReference(DataKtp.class, id);
                dataKtp.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dataKtp with id " + id + " no longer exists.", enfe);
            }
            em.remove(dataKtp);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DataKtp> findDataKtpEntities() {
        return findDataKtpEntities(true, -1, -1);
    }

    public List<DataKtp> findDataKtpEntities(int maxResults, int firstResult) {
        return findDataKtpEntities(false, maxResults, firstResult);
    }

    private List<DataKtp> findDataKtpEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DataKtp.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public DataKtp findDataKtp(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DataKtp.class, id);
        } finally {
            em.close();
        }
    }

    public int getDataKtpCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DataKtp> rt = cq.from(DataKtp.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
