package ir.maktabsharif.repository.Impl;

import ir.maktabsharif.exception.StudentNotFoundException;
import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.GenericRepository;
import ir.maktabsharif.util.HibernateUtil;

import java.util.Optional;

public class StudentRepositoryImpl implements GenericRepository<Student,Long> {

    @Override
    public Long save(Student student) {
        HibernateUtil.inTxResult(em -> {
            em.persist(student);
            return student;
        });
        return student.getId();
    }

    @Override
    public Boolean update(Student student) {
        Student students = HibernateUtil.inTxResult(entityManager -> {
            Student student1 = entityManager.find(Student.class, student.getId());
            if (student1 == null) {
                return null;
            }
            student1.setEmail(student.getEmail());
            student1.setFirstName(student.getFirstName());
            student1.setLastName(student.getLastName());
            student1.setNationalCode(student.getNationalCode());

            return student1;
        });
        return students != null;
    }

    @Override
    public void delete(Long id) {
        HibernateUtil.inTxResult(entityManager -> {
            Student student = entityManager.find(Student.class, id);
            if (student == null) {
                throw new StudentNotFoundException("Student not found");
            }
            entityManager.remove(student);
            return null;
        });
    }

    @Override
    public Optional<Student> findByID(Long id) {
        return Optional.ofNullable(HibernateUtil.inTxResult(entityManager ->
                entityManager.find(Student.class, id)
        ));
    }
}

