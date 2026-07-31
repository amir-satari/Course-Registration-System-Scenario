package ir.maktabsharif.repository.Impl;

import ir.maktabsharif.exception.courseNotFoundException;
import ir.maktabsharif.model.Course;
import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.GenericRepository;
import ir.maktabsharif.util.HibernateUtil;
import jakarta.persistence.EntityManager;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;
import java.util.function.Function;

public class CourseRepositoryImpl implements GenericRepository<Course, Long> {

    @Override
    public Long save(Course course) {
        HibernateUtil.inTxResult(em -> {
            em.persist(course);
            return course;
        });
        return course.getId();
    }

    @Override
    public Boolean update(Course course) {
        Course course2 = HibernateUtil.inTxResult(em -> {
            Course course1 = em.find(Course.class, course.getId());
            if (course1 == null) {
                return null;
            }
            course1.setCapacity(course.getCapacity());
            course1.setInstructor(course.getInstructor());
            course1.setTitle(course.getTitle());
            course1.setCategory(course.getCategory());
            return course1;
        });
        return course2 != null;
    }

    @Override
    public void delete(Long aLong) {
        HibernateUtil.inTxResult(em -> {
            Course course = em.find(Course.class, aLong);
            if (course == null) {
                throw new courseNotFoundException("course not founded!");
            }
            em.remove(course);
            return null;
        });
    }

    @Override
    public Optional<Course> findByID(Long aLong) {
        return Optional.ofNullable(HibernateUtil.inTxResult(em ->
                em.find(Course.class,aLong)
        ));
    }
}
