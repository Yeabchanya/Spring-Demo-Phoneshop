// OrderService

		// Create new order
    OrderDTO createOrder(OrderDTO orderDTO);

    // Update existing order
    OrderDTO updateOrder(Long id, OrderDTO orderDTO);

    // Get order by ID
    Optional<OrderDTO> getOrderById(Long id);

    // Get all orders
    List<OrderDTO> getAllOrders();

    // Delete order by ID
    void deleteOrderById(Long id);

    // Check if order exists by ID
    boolean existsById(Long id);

    // Search orders by customer ID
    List<OrderDTO> findByCustomerId(Long customerId);

    // Search orders by staff ID
    List<OrderDTO> findByStaffId(Long staffId);

    // Filter orders by date range
    List<OrderDTO> findByOrderDateBetween(LocalDateTime start, LocalDateTime end);

    // Calculate total revenue (e.g. daily/monthly report)
    BigDecimal calculateTotalRevenue();

    // Get order with full detail (order + order items)
    Optional<OrderWithDetailsDTO> getOrderWithDetails(Long id);

    // Get all orders with details
    List<OrderWithDetailsDTO> getAllOrdersWithDetails();

    | Method                   | Description                               |
| ------------------------ | ----------------------------------------- |
| `createOrder`            | Place a new customer order                |
| `updateOrder`            | Modify an existing order                  |
| `getOrderById`           | View one order                            |
| `getAllOrders`           | Show all orders                           |
| `deleteOrderById`        | Delete a canceled or wrong order          |
| `findByCustomerId`       | Filter orders by customer                 |
| `findByStaffId`          | Filter orders by staff/salesperson        |
| `findByOrderDateBetween` | Get orders by date range (e.g. this week) |
| `calculateTotalRevenue`  | Useful for reports/dashboard              |
| `getOrderWithDetails`    | Get an order with its item details        |
| `existsById`             | Check if an order exists (for validation) |


// Import service

    // Save a new import record
    ImportDTO saveImport(ImportDTO importDTO);

    // Update existing import by ID
    ImportDTO updateImport(Long id, ImportDTO importDTO);

    // Get import by ID
    Optional<ImportDTO> getImportById(Long id);

    // Get all imports
    List<ImportDTO> getAllImports();

    // Delete import by ID
    void deleteImportById(Long id);

    // Check if an import exists by ID
    boolean existsById(Long id);

    // Search imports by supplier
    List<ImportDTO> findBySupplierId(Long supplierId);

    // Filter by date range
    List<ImportDTO> findByImportDateBetween(LocalDate start, LocalDate end);

    // Calculate total imported amount (e.g., for reporting)
    BigDecimal calculateTotalImportedAmount();

    // Get all imports with details
    List<ImportWithDetailsDTO> getAllImportsWithDetails();

	| Method                         | Purpose                                              |
| ------------------------------ | ---------------------------------------------------- |
| `saveImport`                   | Add a new import entry                               |
| `updateImport`                 | Edit a saved import                                  |
| `getImportById`                | View a single import record                          |
| `getAllImports`                | List all import records                              |
| `deleteImportById`             | Remove an import if needed                           |
| `existsById`                   | Check if an import exists by ID                      |
| `findBySupplierId`             | Find all imports from a specific supplier            |
| `findByImportDateBetween`      | Get imports within a date range (e.g. reports)       |
| `calculateTotalImportedAmount` | Calculate value of all imports (e.g. monthly report) |
| `getAllImportsWithDetails`     | Load imports along with associated items             |


