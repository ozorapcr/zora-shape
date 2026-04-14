class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("USERNAME")

        val welcomeText = if (!username.isNullOrEmpty()) {
            "Halo, $username!"
        } else {
            "Halo!"
        }

        binding.tvWelcomeUser.text = welcomeText

        val desc = binding.tvDesc.text.toString()

        // =====================
        // TOMBOL 1 → RUMUS
        // =====================
        binding.btnRumus.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("title", "Rumus Bangun Ruang")
            intent.putExtra("desc", desc)
            startActivity(intent)
        }

        // =====================
        // TOMBOL 2 → CUSTOM 1
        // =====================
        binding.btnCustom1.setOnClickListener {
            val intent = Intent(this, Custom1Activity::class.java)
            intent.putExtra("title", "Custom 1")
            intent.putExtra("desc", desc)
            startActivity(intent)
        }

        // =====================
        // TOMBOL 3 → CUSTOM 2
        // =====================
        binding.btnCustom2.setOnClickListener {
            val intent = Intent(this, Custom2Activity::class.java)
            intent.putExtra("title", "Custom 2")
            intent.putExtra("desc", desc)
            startActivity(intent)
        }

        // =====================
        // TOMBOL 4 → LOGOUT
        // =====================
        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Logout")
                .setMessage("Yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()

                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()

                    Log.e("Logout", "Berhasil logout")
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()

                    Snackbar.make(binding.root, "Logout dibatalkan", Snackbar.LENGTH_SHORT)
                        .show()

                    Log.e("Logout", "Dibatalkan")
                }
                .show()
        }
    }
}