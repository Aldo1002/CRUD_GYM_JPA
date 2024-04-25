package vista;

import model.Miembros;
import model.Planes;
import model.Inscripciones;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Date;

public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("NombreDeTuPersistencia");

    public static void agregarMiembro(Miembros miembro) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(miembro);
            em.getTransaction().commit();
            System.out.println("Miembro agregado con éxito.");
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void agregarPlan(Planes plan) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(plan);
            em.getTransaction().commit();
            System.out.println("Plan agregado con éxito.");
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void agregarInscripcion(Inscripciones inscripcion) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(inscripcion);
            em.getTransaction().commit();
            System.out.println("Inscripción agregada con éxito.");
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void visualizarMiembros() {
        EntityManager em = emf.createEntityManager();
        try {
            List<Miembros> miembros = em.createQuery("SELECT m FROM Miembro m", Miembros.class).getResultList();
            if (miembros.isEmpty()) {
                System.out.println("No hay miembros en la base de datos.");
            } else {
                System.out.println("Miembros en la base de datos:");
                for (Miembros miembro : miembros) {
                    System.out.println(miembro);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void visualizarPlanes() {
        EntityManager em = emf.createEntityManager();
        try {
            List<Planes> planes = em.createQuery("SELECT p FROM Plan p", Planes.class).getResultList();
            if (planes.isEmpty()) {
                System.out.println("No hay planes en la base de datos.");
            } else {
                System.out.println("Planes en la base de datos:");
                for (Planes plan : planes) {
                    System.out.println(plan);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        // Agregar un nuevo miembro
        Miembros nuevoMiembro = new Miembros();
        nuevoMiembro.setNombre("Juan");
        nuevoMiembro.setApellido("Pérez");
        nuevoMiembro.setEdad(30);
        nuevoMiembro.setEmail("juan@example.com");
        nuevoMiembro.setTelefono("123-456-7890");
        nuevoMiembro.setFechaRegistro(new Date());

        agregarMiembro(nuevoMiembro);

        // Agregar un nuevo plan
        Planes nuevoPlan = new Planes();
        nuevoPlan.setNombre("Plan Económico");
        nuevoPlan.setDescripcion("Acceso básico a todas las áreas de entrenamiento.");
        nuevoPlan.setPrecio(19.99);

        agregarPlan(nuevoPlan);

        // Agregar una nueva inscripción
        Inscripciones nuevaInscripcion = new Inscripciones();
        nuevaInscripcion.setMiembro(nuevoMiembro);
        nuevaInscripcion.setPlan(nuevoPlan);
        nuevaInscripcion.setFechaInicio(new Date());
        nuevaInscripcion.setFechaFin(new Date());

        agregarInscripcion(nuevaInscripcion);

        // Visualizar todos los miembros en la base de datos
        visualizarMiembros();

        // Visualizar todos los planes en la base de datos
        visualizarPlanes();
    }
}
